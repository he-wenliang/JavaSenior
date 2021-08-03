package com.hewl.team.service;

import com.hewl.team.domain.Architect;
import com.hewl.team.domain.Designer;
import com.hewl.team.domain.Employee;
import com.hewl.team.domain.Programmer;

/**
 * 
 * @Description 关于开发团队的管理：添加删除等
 * @author 何文亮
 * @version
 * @date 2021年2月4日下午3:13:15
 *
 */
public class TeamService {

	private static int counter = 1;// member赋值使用
	private final int MAX_MEMBER = 5;// 限制开发团队人数
	private Programmer[] team = new Programmer[MAX_MEMBER];// 保存开发团队成员
	private int total;// 记录开发团队实际人数

	public TeamService() {
		super();
	}

	/**
	 * 
	 * @Description 获取开发团队中成员
	 * @author 何文亮
	 * @date 2021年2月4日下午3:22:25
	 * @return
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	/**
	 * 
	 * @Description 将指定的成员添加到团队当中
	 * @author 何文亮
	 * @date 2021年2月4日下午3:26:33
	 * @param e
	 * @throws TeamException
	 */
	public void addMember(Employee e) throws TeamException {
		// 成员已满，无法添加
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		// 该成员不是开发人员，无法添加
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		// 该员工已在本团队中
		if (isExist(e)) {
			throw new TeamException("该员工已在本团队中");
		}
		// 该员工已是某团队成员
		// 该员正在休假，无法添加
		Programmer p = (Programmer) e;// 不会出现类型转换异常
//		if ("BUSY".equals(p.getStatus().getNAME())) {// if(p.getStatus().getNAME().equals("BUSY")) {
//			throw new TeamException("该员工已是某团队成员");
//		} else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
//			throw new TeamException("该员工正在休假，无法添加");
//		}
		switch (p.getStatus()){//byte short int char String 枚举类
			case BUSY:
				throw new TeamException("该员工已是某团队成员");
			case VOCATION:
				throw new TeamException("该员工正在休假，无法添加");
		}
		// 团队中至多只能有一名架构师
		// 团队中至多只能有两名设计师
		// 团队中至多只能有三名程序员
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			} else if (team[i] instanceof Designer) {
				numOfDes++;
			} else if (team[i] instanceof Programmer) {
				numOfPro++;
			}
		}

		if (p instanceof Architect) {
			if (numOfArch >= 1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		} else if (p instanceof Designer) {
			if (numOfDes >= 2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
		} else if (p instanceof Programmer) {
			if (numOfPro >= 3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}
		// 将p（或e）添加到现有的team种
		team[total++] = p;
		//p的属性
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);

	}

	/**
	 * 
	 * @Description 判断指定的员工是否已经存在
	 * @author 何文亮
	 * @date 2021年2月4日下午3:41:19
	 * @param e
	 * @return
	 */
	private boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			return team[i].getId() == e.getId();

		}
		return false;
	}

	/**
	 * 
	 * @Description 删除团队成员
	 * @author 何文亮
	 * @date 2021年2月4日下午3:27:08
	 * @param memberId
	 * @throws TeamException
	 */
	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for (; i < total; i++) {
			if (team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			} 
		}
		if (i == total) {
			throw new TeamException("找不到该成员，无法删除");
		}
		//后一个覆盖前一个元素
		for (int j = i + 1; j < total; j++) {
			team[j - 1] = team[j];
		}
		//team[total - 1 = null;
		//total--;
		team[--total] = null;
	}

}
