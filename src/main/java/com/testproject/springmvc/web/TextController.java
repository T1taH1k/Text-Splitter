package com.testproject.springmvc.web;

import com.testproject.springmvc.services.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class TextController
{
	@Autowired
	private TextService textService;

	@RequestMapping(value="/split-text", produces= MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Integer> findAll(@RequestBody String str)
	{
		return textService.splitText(str);
	}

	
}
