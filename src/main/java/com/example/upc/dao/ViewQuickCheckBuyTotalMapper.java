package com.example.upc.dao;

import com.example.upc.dataobject.ViewQuickCheckBuyTotal;

import java.util.List;

public interface ViewQuickCheckBuyTotalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_quick_check_buy_total
     *
     * @mbg.generated Tue Aug 13 11:37:16 CST 2019
     */
    int insert(ViewQuickCheckBuyTotal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_quick_check_buy_total
     *
     * @mbg.generated Tue Aug 13 11:37:16 CST 2019
     */
    int insertSelective(ViewQuickCheckBuyTotal record);
    List<ViewQuickCheckBuyTotal> getListAll();
}