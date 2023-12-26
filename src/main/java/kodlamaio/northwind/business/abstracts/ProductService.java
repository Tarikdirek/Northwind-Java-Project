package kodlamaio.northwind.business.abstracts;

import java.util.List;



import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
   
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAllSorted();
   
	DataResult<List<Product>> getAll(int pageNo,int pageSize);
	
    Result add(Product product);
   
    DataResult<Product> getByProductName(String productName);
	
    DataResult <Product> getByProductNameAndCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getCategoryIdIn(List<Integer> categories);
	
	DataResult<List<Product>> getProductNameContains(String productName);
	
	DataResult<List<Product>> getProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
