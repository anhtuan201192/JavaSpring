package co.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.spring.model.WorkModel;

/**
 * @author tuanat.ne
 *
 */
public interface WorkMapper {
	
	/**
	 * Add new work
	 * @param workModel
	 * @return
	 */
	public boolean AddWorkName(WorkModel workModel);

	
	/**
	 * Update current work
	 * @param work
	 * @return
	 */
	public int updateWork(WorkModel work);

	
	/**
	 * Delete work
	 * @param workId
	 * @return
	 */
	public int deleteWorkById(int workId);

	
	/**
	 * get all work
	 * @return
	 */
	public List<WorkModel> GetAllWorkName();

	
	/**
	 * Get work by id
	 * @param workId
	 * @return
	 */
	public String GetWorkNameById(int workId);
	
	/**
	 * get all work
	 * @return
	 */
	public List<WorkModel> SortWorkName(@Param("columnName") String columnName, @Param("asc") boolean asc);

	/**
	 * get all work by paging
	 * @return
	 */
	public List<WorkModel> PagingWorkName(@Param("totalRecord") int totalRecord);
}
