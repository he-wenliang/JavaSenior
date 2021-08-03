package com.hewl.team.junit;

import org.junit.Test;

import com.hewl.team.domain.Employee;
import com.hewl.team.service.NameListService;
import com.hewl.team.service.TeamException;

/**
 * 
 * @Description 对NameListService进行测试
 * @author 何文亮
 * @version
 * @date 2021年2月4日下午2:33:59
 *
 */
public class NameListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}
	}

	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 16;

		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}

}
