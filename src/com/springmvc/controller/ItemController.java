package com.springmvc.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.pojo.Items;
import com.springmvc.pojo.QueryVo;
import com.springmvc.service.ItemService;

@Controller
public class ItemController {

	@Autowired
    private ItemService itemService;

    @RequestMapping("/itemList")
    public ModelAndView getItemsList() throws Exception {
    	
    	/*if (true) {
			throw new CustomerException("自定义异常");
		}*/
    	
        List<Items> itemList = itemService.getItemList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList", itemList);
        modelAndView.setViewName("itemList"); 
        return modelAndView;
    }
    
    @RequestMapping("/itemEdit/{id}")
    public String editItem(@RequestParam(value="id",defaultValue="1",required=true) Integer ids,Model model) {
    	Items items = itemService.getItemById(ids);
    	model.addAttribute("item",items);
    	return "editItem";
    }
    
    @RequestMapping(value="/updateitem",method= {RequestMethod.GET,RequestMethod.POST})
    public String updateItems(Items items,MultipartFile picture) throws Exception {
    	
    	String oriFileName = picture.getOriginalFilename();
    	if (picture != null && oriFileName != null && oriFileName.length() > 0) {
			String picPath = "D:\\\\temp\\\\images\\\\";
			String newFileName = UUID.randomUUID() + oriFileName.substring(oriFileName.indexOf("."));
			picture.transferTo(new File(picPath + newFileName));
			items.setPic(newFileName);
		} else {
			Items temp = itemService.getItemById(items.getId());
			items.setPic(temp.getPic());
		}
        itemService.updateItem(items);
        return "redirect:/itemList.action";
    }
    
    @RequestMapping("/item/queryitem")
    public String queryItem(QueryVo queryVo,Model model) {
    	Items items = itemService.getItemById(queryVo.getItems().getId());
        System.out.println(queryVo.getItems().getId());
        System.out.println(queryVo.getItems().getName());
        for (int i = 0; i < queryVo.getIds().length; i++) {
			System.out.println(queryVo.getIds()[i]);
		}
        for (Items item : queryVo.getItemList()) {
			System.out.println(item.getName());
		}
        model.addAttribute("item",items);
        return "editItem";
    }
    
    @RequestMapping("/itemList2")
    public void itmeList2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter writer = response.getWriter();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        writer.write("{\"id\":\"123\"}");
    }
    
    @RequestMapping("item/json_test")
    @ResponseBody
    public Items jsonTest(@RequestBody Items items) {
    	return items;
    }
}
