package kodlamaio.northwind.api.controllers;

import java.util.List;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("api/products")
@CrossOrigin
@AllArgsConstructor
public class ProductsController {

	private ProductService productService;
	

	
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
	 return	productService.getAll();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return productService.getProductWithCategoryDetails();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return productService.add(product);
	}
	
	@GetMapping("/getbyproductname")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		 return productService.getByProductName(productName);
	}
	
	
	@GetMapping("/getproductnamecontains")
	public DataResult<List<Product>> getProductNameContains(@RequestParam String productName){
		 return productService.getProductNameContains(productName);
	}
	
	@GetMapping("/getproductnamestarswith")
	public DataResult<List<Product>> getProductNameStartsWith(@RequestParam String productName){
		 return productService.getProductNameStartsWith(productName);
	}
	
	@GetMapping("/getbynameandcategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,@RequestParam int categoryId){
		 return productService.getByNameAndCategoryId(productName,categoryId);
	}
	
	@GetMapping("/getallbypage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return productService.getAll(pageNo-1, pageSize);
	}
	
	@GetMapping("/getalldesc")
	public DataResult<List<Product>> getAllSorted(){
		return productService.getAllSorted();
	}
}
