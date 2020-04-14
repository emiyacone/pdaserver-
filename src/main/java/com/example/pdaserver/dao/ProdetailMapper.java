package com.example.pdaserver.dao;

import com.example.pdaserver.entity.Prodetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProdetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(Prodetail record);

    int insertSelective(Prodetail record);

    Prodetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Prodetail record);

    int updateByPrimaryKey(Prodetail record);

    List<Prodetail> selectlist();

    List<Prodetail> selectlistbyfacno(String facno);

    List<String> selectStacknoByBatch(@Param("BatchNo") String BatchNo,@Param("facno") String facno);

    List<String> selectIdByStackno(@Param("StackNo")String StackNo,@Param("facno") String facno);

    List<Prodetail> selectByStackno(@Param("StackNo")String StackNo,@Param("facno") String facno);

    List<Prodetail> selectByBatchNo(@Param("BatchNo")String BatchNo,@Param("facno") String facno);

    int updateBybacketno(@Param("BatchNo")String BatchNo,@Param("isinvoice") int isinvoice);

    int updateByid(@Param("ID")String ID,@Param("isinvoice") int isinvoice);

    int updateBystackno(@Param("Stackno")String Stackno,@Param("isinvoice") int isinvoice);
}