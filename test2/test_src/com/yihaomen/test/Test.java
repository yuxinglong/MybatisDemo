package com.yihaomen.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yihaomen.mybatis.inter.IUserOperation;
import com.yihaomen.mybatis.model.Article;
import com.yihaomen.mybatis.model.User;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 

    static{
        try{
            reader    = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    
    public void getUserArticles(int userid){
    	SqlSession session = sqlSessionFactory.openSession();
    	try {
    	    IUserOperation userOperation=session.getMapper(IUserOperation.class);    	   
    	    List<Article> articles = userOperation.getUserArticles(userid);
    	    for(Article article:articles){
    	    	System.out.println(article.getTitle()+":"+article.getContent()+
    	    			":作者是:"+article.getUser().getUserName()+":地址:"+
    	                 article.getUser().getUserAddress());
    	    }
    	} finally {
    	    session.close();
    	}
    }
    
    public static void main(String[] args) {
    	Test testUser=new Test();
    	testUser.getUserArticles(1);
	}    
  
}