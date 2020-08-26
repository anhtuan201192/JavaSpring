package co.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.spring.model.WorkModel;
import co.spring.service.WorkService;

@Controller
public class WorkController {
	
	@Autowired
	public WorkService workNameService;
	
	/**
	 * Get all work
	 * @return
	 */
	@ResponseBody 
	@RequestMapping(value = "/workname", 
			method = RequestMethod.GET, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<WorkModel>> GetAllWorkName() {
		return new ResponseEntity<>(workNameService.GetAllWorkName(), HttpStatus.OK);
	}
	
	/**
	 * Get work by work id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/workname/{id}", 
			method = RequestMethod.GET, 
		    produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> GetWorkName(@PathVariable("id") int id) {
		return new ResponseEntity<>(workNameService.GetWorkName(id), HttpStatus.OK);
	}
	
	/**
	 * Add new work
	 * @return
	 */
	@RequestMapping(value = "/workname", 
            method = RequestMethod.POST, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> AddWorkName(@RequestBody WorkModel work) {
		if (workNameService.AddWorkName(work)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * update work
	 * @return
	 */
	@RequestMapping(value = "/workname", 
            method = RequestMethod.PUT, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> UpdateWorkName(@RequestBody WorkModel work) {
		if (workNameService.updateWork(work) != null) {
			return new ResponseEntity<>(work, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Delete work
	 * @return
	 */
	@RequestMapping(value = "/workname/{id}", 
            method = RequestMethod.DELETE, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> DeleteWorkName(@PathVariable("id") int id) {
		if (workNameService.deleteWorkById(id) > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Sort data of work
	 * @return
	 */
	@RequestMapping(value = "/workname/{columnName}/{asc}", 
            method = RequestMethod.GET, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<WorkModel>> SortWorkName(@PathVariable("columnName") String columnName, @PathVariable("asc") boolean asc) {
		List<WorkModel> result = workNameService.SortWorkName(columnName, asc);
		if (result != null && result.size() > 0) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Paging
	 * @param totalRecord
	 * @return
	 */
	@RequestMapping(value = "/workname/paging/{totalRecord}", 
            method = RequestMethod.GET, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<WorkModel>> PagingWorkName(@PathVariable("totalRecord") int totalRecord) {
		List<WorkModel> result = workNameService.PagingWorkName(totalRecord);
		if (result != null && result.size() > 0) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

}
