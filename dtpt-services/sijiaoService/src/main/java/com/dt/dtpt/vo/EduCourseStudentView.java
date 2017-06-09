package com.dt.dtpt.vo;

import java.io.Serializable;

import com.dt.dtpt.mybatis.model.sijiao.EduCourse;
import com.dt.dtpt.mybatis.model.sijiao.EduCourseStudent;

public class EduCourseStudentView implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EduCourse eduCourse;
	private EduCourseStudent eduCourseStudent;
	public EduCourse getEduCourse() {
		return eduCourse;
	}
	public void setEduCourse(EduCourse eduCourse) {
		this.eduCourse = eduCourse;
	}
	public EduCourseStudent getEduCourseStudent() {
		return eduCourseStudent;
	}
	public void setEduCourseStudent(EduCourseStudent eduCourseStudent) {
		this.eduCourseStudent = eduCourseStudent;
	}
	
}
