package com.example.upc.dao;

import com.example.upc.dataobject.ViewQuickCheckBuyTopTen;

import java.util.List;

public interface ViewQuickCheckBuyTopTenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_quick_check_buy_top_ten
     *
     * @mbg.generated Tue Aug 13 11:34:01 CST 2019
     */
    int insert(ViewQuickCheckBuyTopTen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_quick_check_buy_top_ten
     *
     * @mbg.generated Tue Aug 13 11:34:01 CST 2019
     */
    int insertSelective(ViewQuickCheckBuyTopTen record);
    List<ViewQuickCheckBuyTopTen> getListAll();
}