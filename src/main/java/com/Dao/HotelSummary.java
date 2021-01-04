package com.Dao;


import com.Model.UserInfo;

/**
 * @author guanzhiding
 * @date 2020/12/25 14:54
 */
public interface HotelSummary {
    UserInfo getUserInfo();

    String getName();

    Double getAverageRating();

    default Integer getAverageRatingRounded() {
        return getAverageRating() == null ? null : (int) Math.round(getAverageRating());
    }
}
