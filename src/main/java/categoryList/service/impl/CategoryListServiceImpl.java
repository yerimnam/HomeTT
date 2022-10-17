package categoryList.service.impl;

import categoryList.dao.face.CategoryListDao;
import categoryList.dao.impl.CategoryListDaoImpl;
import categoryList.dto.CategoryList;
import categoryList.service.face.CategoryListService;

public class CategoryListServiceImpl implements CategoryListService {
	
	private CategoryListDao catelistdao = new CategoryListDaoImpl();

	@Override
	public CategoryList getCategoryList() {
		return null;
	}
	

}
