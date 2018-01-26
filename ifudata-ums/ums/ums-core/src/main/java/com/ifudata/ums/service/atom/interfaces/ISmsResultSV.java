package com.ifudata.ums.service.atom.interfaces;


import com.ifudata.ums.dao.mapper.bo.SmsResult;

public interface ISmsResultSV {
   SmsResult queryByResflag(Integer id);
}
