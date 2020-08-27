/**
 * 
 */
package co.spring;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.spring.constant.Constant;
import co.spring.controller.WorkController;
import co.spring.model.WorkModel;
import co.spring.service.WorkService;

/**
 * @author tuanat.ne
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = WorkController.class)
@WithMockUser
public class WorkControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WorkService workService;
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	WorkModel workMock = new WorkModel(1,"WorkName", new Date(), new Date(), 1, Constant.Doing);

	/**
	 * Test GetWorkNameById
	 * @throws Exception
	 */
	@Test
	public void GetWorkNameById() throws Exception {
		Mockito.when(
				workService.GetWorkById(Mockito.anyInt())).thenReturn(workMock.getWorkName());		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/workname/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "WorkName";

		assertEquals(expected, result.getResponse()
				.getContentAsString()); 
	}
	
	/**
	 * Test GetAllWorkName
	 * @throws Exception
	 */
	@Test
	public void GetAllWorkName() throws Exception {

		workMock = new WorkModel(1,"WorkName", df.parse("02-02-2020 23:30:50"), df.parse("02-03-2020 23:37:50"), 1, Constant.Doing);
		List<WorkModel> allWork = Arrays.asList(workMock);
		Mockito.when(
				workService.GetAllWork()).thenReturn(allWork);		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/workname").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{\"status\":1,\"workName\":\"WorkName\",\"workId\":1,\"startDate\":\"2020-02-02T16:30:50.000+00:00\",\"statusDisplay\":\"Doing\",\"endDate\":\"2020-03-02T16:37:50.000+00:00\"}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	/**
	 * Test AddWorkName
	 * @throws Exception
	 */
	@Test
	public void AddWorkName() throws Exception {

		workMock = new WorkModel(1,"WorkName", df.parse("02-02-2020 23:30:50"), df.parse("02-03-2020 23:37:50"), 1, Constant.Doing);

		Mockito.when(
				workService.AddWork(Mockito.any(WorkModel.class))).thenReturn(true);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/workname")
				.accept(MediaType.APPLICATION_JSON).content("{\r\n" + 
						"        \"startDate\": \"2020-08-26T08:25:03.000+00:00\",\r\n" + 
						"        \"workName\": \"Work2\",\r\n" + 
						"        \"endDate\": \"2020-08-26T08:25:03.000+00:00\",\r\n" + 
						"        \"status\": 2,\r\n" + 
						"        \"workId\": 19\r\n" + 
						"    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	/**
	 * Test updateWork
	 * @throws Exception
	 */
	@Test
	public void updateWork() throws Exception {

		workMock = new WorkModel(1,"WorkName", df.parse("02-02-2020 23:30:50"), df.parse("02-03-2020 23:37:50"), 1, Constant.Doing);

		Mockito.when(
				workService.UpdateWork(Mockito.any(WorkModel.class))).thenReturn(workMock);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/workname")
				.accept(MediaType.APPLICATION_JSON).content("{\r\n" + 
						"        \"startDate\": \"2020-08-26T08:25:03.000+00:00\",\r\n" + 
						"        \"workName\": \"Work2\",\r\n" + 
						"        \"endDate\": \"2020-08-26T08:25:03.000+00:00\",\r\n" + 
						"        \"status\": 2,\r\n" + 
						"        \"workId\": 19\r\n" + 
						"    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	/**
	 * Test deleteWorkById
	 * @throws Exception
	 */
	@Test
	public void deleteWorkById() throws Exception {

		workMock = new WorkModel(1,"WorkName", df.parse("02-02-2020 23:30:50"), df.parse("02-03-2020 23:37:50"), 1, Constant.Doing);

		Mockito.when(
				workService.DeleteWorkById(Mockito.anyInt())).thenReturn(1);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/workname/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	/**
	 * Test SortWorkName
	 * @throws Exception
	 */
	@Test
	public void SortWorkName() throws Exception {

		workMock = new WorkModel(1,"WorkName", df.parse("02-02-2020 23:30:50"), df.parse("02-03-2020 23:37:50"), 1, Constant.Doing);
		List<WorkModel> allWork = Arrays.asList(workMock);
		Mockito.when(
				workService.SortWorkName(Mockito.anyString(), Mockito.anyBoolean())).thenReturn(allWork);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/workname/WorkName/true")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String expected = "[{\"status\":1,\"workName\":\"WorkName\",\"workId\":1,\"startDate\":\"2020-02-02T16:30:50.000+00:00\",\"statusDisplay\":\"Doing\",\"endDate\":\"2020-03-02T16:37:50.000+00:00\"}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	/**
	 * Test PagingWorkName
	 * @throws Exception
	 */
	@Test
	public void PagingWorkName() throws Exception {

		workMock = new WorkModel(1,"WorkName", df.parse("02-02-2020 23:30:50"), df.parse("02-03-2020 23:37:50"), 1, Constant.Doing);
		List<WorkModel> allWork = Arrays.asList(workMock);
		Mockito.when(
				workService.PagingWorkName(Mockito.anyInt())).thenReturn(allWork);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/workname/paging/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String expected = "[{\"status\":1,\"workName\":\"WorkName\",\"workId\":1,\"startDate\":\"2020-02-02T16:30:50.000+00:00\",\"statusDisplay\":\"Doing\",\"endDate\":\"2020-03-02T16:37:50.000+00:00\"}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
