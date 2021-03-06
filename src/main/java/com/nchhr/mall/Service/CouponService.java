package com.nchhr.mall.Service;

import com.nchhr.mall.Dao.CouponDao;
import com.nchhr.mall.Entity.CouponEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CouponService {

    @Resource
    private CouponDao couponDao;

    public List<CouponEntity> getCoupons(String userId, String state) {
//        List<CouponEntity> coupons = couponDao.getCoupons(userId, state);
//        System.out.println(coupons.toString());
//        return coupons;

        return couponDao.getCoupons(userId, state);
    }

    /*
     *通过ofid
     * HWG
     *
     */
    public CouponEntity getCouponByOfid(String OFid){
        return couponDao.getCouponById(OFid);
    }

    /*
     *使用一个优惠券
     * HWG
     */
    public void useCoupon(String OFid){
        couponDao.updateCouponUsageInfo(OFid);
    }
}
