package co.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.spring.model.WorkModel;


/**
 * @author tuanat.ne
 *
 */
@Service
public interface WorkService {

	/**
	 * Get all work name
	 * @return List<String>
	 */
	List<WorkModel> GetAllWorkName();
	

	/**
	 * Get work name by id
	 * 
	 * @param id string
	 * @return string
	 */
	String GetWorkName(int id);
	
	/**
	 * Add new work name
	 * 
	 * @param workName WorkNameModel
	 * @return boolean
	 */
	boolean AddWorkName(WorkModel workName);
	
	/**
	 * Update current work
	 * @param work
	 * @return
	 */
	public WorkModel updateWork(WorkModel work);

	
	/**
	 * Delete work
	 * @param workId
	 * @return
	 */
	public int deleteWorkById(int workId);
	
	/**
	 * Get all work name with sorting
	 * @return List<String>
	 */
	public List<WorkModel> SortWorkName(String columnName, boolean asc);

	/**
	 * Get all work name by paging
	 * @return List<String>
	 */
	public List<WorkModel> PagingWorkName(int totalRecord);
}
