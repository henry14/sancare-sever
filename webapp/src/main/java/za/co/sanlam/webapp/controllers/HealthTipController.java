package za.co.sanlam.webapp.controllers;

//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import za.co.sanlam.model.Tip;
import za.co.sanlam.model.User;
import za.co.sanlam.security.util.SancareSecurityUtil;
//import za.co.sanlam.server.service.BeneficiaryService;
import za.co.sanlam.server.service.TipService;

/**
 * @author henry14
 * 
 */
@Controller
@RequestMapping(value="tip")
public class HealthTipController {
	
//	private static String apiKey = "AIzaSyDO_11HlQ6FeqQz2VCTy76vanVhMEArMqo";
	
	@Autowired
	private TipService tipService;
	/*@Autowired
	private BeneficiaryService beneficiaryService;*/
	private static final String DISPLAY_NAME = "Health Tip";
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "view")
	public ModelAndView viewTips(ModelMap modelMap) {
		Tip tip = new Tip();
		List<Tip> tips = tipService.getAll();
		modelMap.put("tip", tip);
		modelMap.put("tips", tips);
		return new ModelAndView("tipView", modelMap);
	}
	
	@RequestMapping(value = "add")
	public ModelAndView addTip(ModelMap modelMap) {
		Tip tip = new Tip();
		modelMap.put("tip", tip);
		return new ModelAndView("tipAdd");
	}
	
	@RequestMapping("edit/{tipId}")
	public ModelAndView editTip(@PathVariable("tipId") String tipId, ModelMap modelMap){
		Tip tip = tipService.getById(tipId);
		if(tip != null){
			modelMap.put("tip", tip);
			
			return new ModelAndView("tipAdd", modelMap);
		}
		
		return new ModelAndView("tipAdd");//, model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete/{tipIds}")
	public ModelAndView delete(	@PathVariable("tipIds") String tipIds, 
			ModelMap modelMap) {
		String[] idzToDelete = tipIds.split(",");
		try {
			tipService.deleteByIds(idzToDelete);

		} catch (Exception e) {
			/*log.error("Error", e);

			modelMap.put(WebConstants.MODEL_ATTRIBUTE_ERROR_MESSAGE,
					e.getMessage());*/
		}
		return viewTips(modelMap);
	}
	
	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute("tip") Tip tip, ModelMap model){
		Tip exisiting = tip;
		
		try{
			User user = SancareSecurityUtil.getLoggedInUser();
			if(StringUtils.isNotEmpty(exisiting.getId())){
				exisiting.setCreatedBy(tipService.getCreatedBy(exisiting.getId()));
				exisiting.setCreatedDate(tipService.getCreatedDate(exisiting.getId()));
				exisiting.setLastModifiedBy(user);
			} else{
				exisiting.setId(null);
				exisiting.setCreatedBy(user);
//				sendJson();
			}
			tipService.validate(exisiting);
			tipService.save(exisiting);
			
			model.put(WebConstants.SYSTEM_MESSAGE, DISPLAY_NAME+" saved successfully");
			
		} catch (Exception ex){
			log.error("Error", ex);
			ApplicationController.addErrorMessage(model, ex.getMessage());
			
			return addTip(model);
			
		}
		return viewTips(model);
	}
	
	@RequestMapping(value = "api/get", method = RequestMethod.GET)
	public @ResponseBody List<Tip> getTips() {
		List<Tip> tips = tipService.getAll();
		return tips;
	}
	
	/*@RequestMapping(value = "api/get/{username}", method = RequestMethod.GET)
	public @ResponseBody
	List<Tip> getTips(@PathVariable("username") String username) {
		Beneficiary beneficiary = beneficiaryService.getBeneficiaryByusername(username);
		List<Tip> tips = tipService.getTipByClient(beneficiary);
		return tips;
	}*/
	
	/*private void sendJson(){
		try {
			URL url = new URL("https://android.googleapis.com/gcm/send");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("project_id", "433563895236");
			conn.setRequestProperty("Authorization", "key="+apiKey);
			conn.setDoOutput(true);	
			
			ObjectMapper mapper = new ObjectMapper();
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			mapper.writeValue(wr, createContent());
			wr.flush();
			wr.close();
			
			
//			int responseCode = conn.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = reader.readLine()) != null){
				response.append(inputLine);
			}
			reader.close();
			
			System.out.println(response.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	/*private Content createContent(){
		Content c = new Content();
		c.addRegId("4");
		c.addRegId("8");
		c.createDate("create", "appUser-Henry");
		return c;
	}*/

}
