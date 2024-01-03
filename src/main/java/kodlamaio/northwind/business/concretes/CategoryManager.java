package kodlamaio.northwind.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.CategoryService;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.CategoryDao;
import kodlamaio.northwind.entities.concretes.Category;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

	CategoryDao categoryDao;

	@Override
	public Result add(Category category) {
		categoryDao.save(category);
		
		return new SuccessResult("Kategori başarılı bir şekilde eklendi");
	}

}
