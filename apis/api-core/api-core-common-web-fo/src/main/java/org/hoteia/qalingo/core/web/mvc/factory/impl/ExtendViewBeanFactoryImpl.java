package org.hoteia.qalingo.core.web.mvc.factory.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hoteia.qalingo.core.domain.CatalogCategoryVirtual;
import org.hoteia.qalingo.core.domain.Localization;
import org.hoteia.qalingo.core.domain.enumtype.FoUrls;
import org.hoteia.qalingo.core.pojo.RequestData;
import org.hoteia.qalingo.core.web.mvc.factory.ExtendViewBeanFactory;
import org.hoteia.qalingo.core.web.mvc.viewbean.CategoryViewBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("viewBeanFactory")
@Transactional
public class ExtendViewBeanFactoryImpl extends ViewBeanFactoryImpl implements ExtendViewBeanFactory{

    /* (non-Javadoc)
     * @see org.hoteia.qalingo.core.web.mvc.factory.ViewBeanFactory#buildCategoryViewBean(org.hoteia.qalingo.core.pojo.RequestData, java.util.List)
     */
    public List<CategoryViewBean> buildVirtualCategoryViewBeans(final RequestData requestData, final List<CatalogCategoryVirtual> categories, boolean fullPopulate) throws Exception {
    	
    	List<CategoryViewBean> categoryViewBeans = new ArrayList<CategoryViewBean>();
        for (Iterator<CatalogCategoryVirtual> iterator = categories.iterator(); iterator.hasNext();) {
            final CatalogCategoryVirtual category = (CatalogCategoryVirtual) iterator.next();
            categoryViewBeans.add(buildVirtualCategoryViewBean(requestData, category, fullPopulate));
        }
        
        return categoryViewBeans;
    }
    /**
     * @throws Exception
     * 
     */
    public CategoryViewBean buildVirtualCategoryViewBean(final RequestData requestData, final CatalogCategoryVirtual category, boolean fullPopulate) throws Exception {
        final Localization localization = requestData.getLocalization();

        final String localeCode = localization.getCode();
        final CategoryViewBean CategoryViewBean = new CategoryViewBean();

        if (category != null) {
            final String categoryCode = category.getCode();

            CategoryViewBean.setName(category.getI18nName(localeCode));
            CategoryViewBean.setCode(categoryCode);


            if (fullPopulate) {
                if (category.getCatalogCategories() != null) {
                    CategoryViewBean.setSubCategories(buildVirtualCategoryViewBeans(requestData, new ArrayList<CatalogCategoryVirtual>(category.getCatalogCategories()), fullPopulate));
                }

            }
            CategoryViewBean.setCategoryUrl(urlService.generateUrl(FoUrls.CATEGORY_AS_LINE, requestData, category));

        }

        return CategoryViewBean;
    }
	
}
