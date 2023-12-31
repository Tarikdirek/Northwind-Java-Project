package kodlamaio.northwind.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserDao;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

	private UserDao userDao;


	@Override
	public Result add(User user) {
		userDao.save(user);
		return new SuccessResult("Kullanıcı başarılı bir şekilde oluşturuldu");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		var result = userDao.findByEmail(email);
		return new SuccessDataResult<User>(result,"Kullanıcılar listelendi");
	}

}
