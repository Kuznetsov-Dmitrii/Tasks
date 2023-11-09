package com.example.MeetingSymbols;


import com.example.MeetingSymbols.Dto.StringTaskDto;
import com.example.MeetingSymbols.controllers.TaskController;
import com.example.MeetingSymbols.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MeetingSymbolsApplicationTests {

	@Mock
	TaskService taskService;

	@InjectMocks
	TaskController taskController;

	@Test
	void meetingSymbol_ReturnValidString() {
		var str=String.valueOf("\"a\": 5, \"c\": 4, \"b\": 1");
		doReturn(str).when(this.taskService).meetingSymbol("aaaaabcccc");

		var responseEntity= this.taskController.meetingSymbol(new StringTaskDto("aaaaabcccc"));

		assertNotNull(responseEntity);
		assertEquals(str,responseEntity);
		
	}

}
