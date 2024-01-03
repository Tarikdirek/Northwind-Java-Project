package kodlamaio.northwind.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.CategoryService;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Category;

@RestController
@RequestMapping("api/categories")
@CrossOrigin
@AllArgsConstructor
public class CategoryController {

	private CategoryService categoryService;

	
	public Result add(Category category) {
		
		return categoryService.add(category);
	}
	
}
