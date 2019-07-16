package com.tw.apistackbase;

import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Re
@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class ApiStackBaseApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeService employeeService;

	@Test
	public void should_find_employee_by_id()throws Exception{
		Employee employee = new Employee();
		employee.setId("111");
		employee.setAge(20);
		employee.setGendar("Male");
		employee.setName("lxy");

		when(employeeService.findByID(anyString())).thenReturn(employee);
		ResultActions result = mockMvc.perform(get("/employee/{employeeID}",employee.getId()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name",is("lxy")))
				.andExpect(jsonPath("$.age",is(20)))
				.andExpect(jsonPath("$.gendar",is("Male")));




		
	}

}
