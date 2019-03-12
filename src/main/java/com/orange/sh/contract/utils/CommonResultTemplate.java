package com.orange.sh.contract.utils;

import org.slf4j.LoggerFactory;

import com.orange.sh.common.CommonResult;
import com.orange.sh.contract.type.ErrorCode;

public class CommonResultTemplate {

//	public static CommonResult execute(Callback callback) {
//        CommonResult result;
//
//        try {
//            result = new CommonResult();
//            result.setData(callback.execute());
//
//        } catch (NotException e) {
//
//            LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[3].getClassName()).debug("business " +
//                    "error", e);
//
//            if (e.getErrorCode() != null) {
//                result = new CommonResult(e.getErrorCode());
//            } else {
//                result = new CommonResult(e.getMessage());
//            }
//        } catch (Exception e) {
//
//            LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[3].getClassName()).debug("business " +
//                    "error", e);
//
//            result = new CommonResult(ErrorCode.SERVER_ERROR);
//        }
//
//        return result;
//    }
//
//    public interface Callback {
//        Object execute();
//    }
}
