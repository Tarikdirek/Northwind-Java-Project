package kodlamaio.northwind.business.concretes;


import java.util.List;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

	private ProductDao productDao;
	


	@Override
	public DataResult<List<Product>> getAll() {
		
	 var result =productDao.findAll();
		
		return new SuccessDataResult<List<Product>>(result,"Data listelendi");
	}

	@Override
	public Result add(Product product) {
		productDao.save(product);
		
		return new SuccessResult("Ürün veritabanına eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {

		 var result =productDao.getByProductName(productName);
			
			return new SuccessDataResult<Product>(result,"Data listelendi");
		
		
	}


	@Override
	public DataResult<List<Product>> getProductNameContains(String productName) {
		var result =productDao.getByProductNameContains(productName);
		
		return new SuccessDataResult<List<Product>>(result,"Data listelendi");	
	}

	@Override
	public DataResult<List<Product>> getProductNameStartsWith(String productName) {
		var result =productDao.getByProductNameStartsWith(productName);
		
		return new SuccessDataResult<List<Product>>(result,"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
		var result =productDao.getByNameAndCategory(productName,categoryId);
		
		return new SuccessDataResult<List<Product>>(result,"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		var result = this.productDao.findAll(pageable);
		
		return new SuccessDataResult<List<Product>>(result.getContent());
		
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		
		var result = this.productDao.findAll(sort);
		
		return new SuccessDataResult<List<Product>>(result);
	}

	@Override
	public DataResult<List <ProductWithCategoryDto>> getProductWithCategoryDetails() {
		var result = productDao.getProductWithCategoryDetails();
		
		return new SuccessDataResult<List<ProductWithCategoryDto>>(result);
	}

	

}
