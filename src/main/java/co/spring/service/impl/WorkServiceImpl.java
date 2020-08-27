package co.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.spring.mapper.WorkMapper;
import co.spring.model.WorkModel;
import co.spring.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService{

	@Autowired
	WorkMapper workMapper;
	
	/**
	 * Get all work name
	 * @return List<String>
	 */
	@Override
	public List<WorkModel> GetAllWork() {
		
		return workMapper.GetAllWorkName();
	}

	/**
	 * Get work name by id
	 * 
	 * @param id string
	 * @return string
	 */
	@Override
	public String GetWorkById(int id) {
		return workMapper.GetWorkNameById(id);
	}

	/**
	 * Add new work name
	 * 
	 * @param workName WorkNameModel
	 * @return boolean
	 */
	@Override
	public boolean AddWork(WorkModel workModel) {
		return workMapper.AddWorkName(workModel);
	}
	
	/**
	 * Update current work
	 * @param work
	 * @return
	 */
	@Override
	public WorkModel UpdateWork(WorkModel work) {
		int result = workMapper.updateWork(work);
		if (result < 1) {
			return null;
		}
		return work;
	}

	/**
	 * Delete work
	 * @param workId
	 * @return
	 */
	@Override
	public int DeleteWorkById(int workId) {
		return workMapper.deleteWorkById(workId);
	}

	/**
	 * Get all work name with sorting
	 * @return List<String>
	 */
	@Override
	public List<WorkModel> SortWorkName(String columnName, boolean asc) {
		return workMapper.SortWorkName(columnName, asc);
	}

	/**
	 * Get all work name by paging
	 * @return List<String>
	 */
	@Override
	public List<WorkModel> PagingWorkName(int totalRecord) {
		return workMapper.PagingWorkName(totalRecord);
	}

}
