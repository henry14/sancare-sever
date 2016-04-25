package za.co.sanlam.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import za.co.sanlam.model.Query;
import za.co.sanlam.server.service.BeneficiaryService;
import za.co.sanlam.server.service.QueryService;

/**
 * @author henry14
 * 
 */
@Controller
@RequestMapping(value = "query")
public class QueryController {

	@Autowired
	private QueryService queryService;
	
	@Autowired
	private BeneficiaryService beneficiaryService;
	
	@RequestMapping(value = "view")
	public ModelAndView viewQueries(ModelMap modelMap){
		Query query = new Query();
		List<Query> queries = queryService.getAll();
		modelMap.put("query", query);
		modelMap.put("querys", queries);
		return new ModelAndView("queryView", modelMap);
	}
	
	@RequestMapping(value = "edit/{id}")
	public ModelAndView addQuery(@PathVariable("id") String id, ModelMap modelMap){
		Query query = queryService.getById(id);
		List<Query> queries = queryService.getAll();
			if(query != null){
				modelMap.put("querys", queries);
				modelMap.put("query", query);
				return new ModelAndView("queryAdd", modelMap);
			} 
			return new ModelAndView("queryAdd");
	}

}
