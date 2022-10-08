package org.example.mvc.view;

import static org.example.mvc.view.RedirectView.DEFAULT_REDIRECT_PREFIX;

public class JspViewResolver implements ViewResolver {  // 뷰를 결정
    @Override
    public View resolveView(String viewName) {
        if (viewName.startsWith(DEFAULT_REDIRECT_PREFIX)) {  // redirect
            return new RedirectView(viewName);
        }
        return new JspView(viewName + ".jsp"); // jsp
    }
}
