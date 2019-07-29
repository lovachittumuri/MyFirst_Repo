# MyFirst_Repo
This is My First Repo

Check This :

package com.jeejava.dto;

public class QIList {

	private long qid;
	private String status;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public QIList(long qid, String status) {
		super();
		this.qid = qid;
		this.status = status;
	}
	public long getQid() {
		return qid;
	}
	public void setQid(long qid) {
		this.qid = qid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "QIList [qid=" + qid + ", status=" + status + ", count=" + count + "]";
	}
	@Override
    public boolean equals(Object obj) { 
		QIList qiList = (QIList) obj; 
        return this.qid== qiList.getQid() && this.status.equals(qiList.getStatus()); 
    } 
}


***************************************************************************************

package com.jeejava.controller.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeejava.dto.QIList;
import com.jeejava.entity.QIStatus;
import com.jeejava.repository.QIStatusRepository;

@RestController
public class QIController {

	@Autowired
	private QIStatusRepository qiStatusRepository;

	@GetMapping("/qi/findAll")
	public ResponseEntity<List<QIStatus>> getStudent() {
		// return new
		// ResponseEntity<List<QIStatus>>(qiStatusRepository.findAll(),HttpStatus.OK);
		List<QIStatus> list = qiStatusRepository.findQIStatus();
		List<QIList> qiList = new ArrayList<>();
		List<QIList> finalList = new ArrayList<>();
		for (QIStatus qiStatus : list) {
			qiList.add(new QIList(qiStatus.getQid(), qiStatus.getStatus()));
		}
		System.out.println(qiList);
		System.out.println("\n");
		for (QIList qil : qiList) {
			if (Collections.frequency(qiList, qil) >= 1) {
				if (!finalList.contains(qil)) {
					qil.setCount(Collections.frequency(qiList, qil));
					finalList.add(qil);
				}
			}
		}
		System.out.println(finalList);
		return new ResponseEntity<List<QIStatus>>(list, HttpStatus.OK);
	}

}
