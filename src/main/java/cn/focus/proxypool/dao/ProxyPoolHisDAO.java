package cn.focus.proxypool.dao;

import java.util.List;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import cn.focus.proxypool.model.ProxyPoolHis;
@DAO(catalog="focus.proxy")
public interface ProxyPoolHisDAO {

	@SQL("SELECT  id, ip, port, level, status, createtime, updatetime, failures, source FROM proxy_pool_his WHERE id = :1")
	ProxyPoolHis get(Integer id );

	
	@SQL("SELECT  id, ip, port, level, status, createtime, updatetime, failures, source FROM proxy_pool_his WHERE id IN (:1)")
	List<ProxyPoolHis> getList(List<Integer> idList );
	
	@SQL("SELECT  id, ip, port, level, status, createtime, updatetime, failures, source FROM proxy_pool_his WHERE status = -1 or status = 0")
	List<ProxyPoolHis> getUsableData( );
	
	
	@SQL("SELECT  id, ip, port, level, status, createtime, updatetime, failures, source FROM proxy_pool_his WHERE id IN (:1) ORDER BY find_in_set(id , :2)")
	List<ProxyPoolHis> getOrderList(List<Integer> idList, String orderIdsStr );
    
	    @ReturnGeneratedKeys
	@SQL("INSERT INTO proxy_pool_his ("+
				      /* "id"+*/
	    	    				    	       "#if(:1.ip!=null){ip}"+
	    				    	       "#if(:1.port!=null){,port}"+
	    				    	       "#if(:1.level!=null){,level}"+
	    				    	       "#if(:1.status!=null){,status}"+
	    				    	       "#if(:1.createtime!=null){,createtime}"+
	    				    	       "#if(:1.updatetime!=null){,updatetime}"+
	    				    	       "#if(:1.failures!=null){,failures}"+
	    				    	       "#if(:1.source!=null){,source}"+
	    		") VALUES("+
		    	      /* ":1.id"+*/
	    	    		    	    	       "#if(:1.ip!=null){:1.ip}"+
	    		    	    	       "#if(:1.port!=null){,:1.port}"+
	    		    	    	       "#if(:1.level!=null){,:1.level}"+
	    		    	    	       "#if(:1.status!=null){,:1.status}"+
	    		    	    	       "#if(:1.createtime!=null){,:1.createtime}"+
	    		    	    	       "#if(:1.updatetime!=null){,:1.updatetime}"+
	    		    	    	       "#if(:1.failures!=null){,:1.failures}"+
	    		    	    	       "#if(:1.source!=null){,:1.source}"+
	    		")") 
	Long save(ProxyPoolHis proxypoolhis );
	
		@SQL("UPDATE proxy_pool_his SET id=:1.id " +
		    		    	       "#if(:1.ip!=null){,ip=:1.ip}"+
	    		    	       "#if(:1.port!=null){,port=:1.port}"+
	    		    	       "#if(:1.level!=null){,level=:1.level}"+
	    		    	       "#if(:1.status!=null){,status=:1.status}"+
	    		    	       "#if(:1.createtime!=null){,createtime=:1.createtime}"+
	    		    	       "#if(:1.updatetime!=null){,updatetime=:1.updatetime}"+
	    		    	       "#if(:1.failures!=null){,failures=:1.failures}"+
	    		    	       "#if(:1.source!=null){,source=:1.source}"+
	    	    " WHERE id=:1.id ")
	void update(ProxyPoolHis proxypoolhis );
	
	@SQL("DELETE FROM proxy_pool_his WHERE id= :1")
	int delete(Integer id);
	
	@SQL("SELECT COUNT(1) FROM proxy_pool_his")
	int count();
	
}