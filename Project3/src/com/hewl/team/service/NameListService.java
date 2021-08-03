package com.hewl.team.service;

import static com.hewl.team.service.Data.*;

import com.hewl.team.domain.*;

/**
 * 
 * @Description
 * @author 何文亮
 * @version v1.0
 * @date 2021年2月3日下午9:08:57
 *
 */
public class NameListService {
	
	private Employee[] employees;

	public NameListService() {
//		 构造器:
//		 根据项目提供的Data类构建相应大小的employees数组
//		 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，
//		 以及相关联的Equipment子类的对象. 将对象存于数组中 Data类位于com.atguigu.team.service包中
		employees = new Employee[EMPLOYEES.length];
		for(int i = 0;i < employees.length;i++) {
			//获取员工类型
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			//获取Employee的4个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;
			
			switch(type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][4]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][4]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}
	/**
	 * 
	 * @Description 获取指定index位置上的员工的设备
	 * @author 何文亮
	 * @date 2021年2月4日下午1:07:03
	 * @param index
	 * @return
	 */
	private Equipment createEquipment(int index) {
		
		int key = Integer.parseInt(EQUIPMENTS[index][0]); 
		String modelOrName = EQUIPMENTS[index][1];
		
		switch(key) {
			case PC://21
				String display = EQUIPMENTS[index][2];
				return new PC(modelOrName, display);
			case NOTEBOOK://22
				double price = Double.parseDouble(EQUIPMENTS[index][2]);
				return new NoteBook(modelOrName, price);
			case PRINTER://23
				String type = EQUIPMENTS[index][2];
				return new Printer(modelOrName, type);
		}
		return null;
	}
	/**
	 * 
	 * @Description 获取当前所有的员工
	 * @author 何文亮
	 * @date 2021年2月4日下午2:21:02
	 * @return
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}
	/**
	 * 
	 * @Description 获取指定ID的员工
	 * @author 何文亮
	 * @date 2021年2月4日下午2:23:48
	 * @param id
	 * @return
	 * @throws TeamException
	 */
	public Employee getEmployee(int id) throws TeamException{
		for(int i = 0;i < employees.length;i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");
	}
	
}

