package com.liuchao.myService;

import com.liuchao.annotation.Autowired;
import com.liuchao.annotation.Service;

@Service
public class OrderService {
    @Autowired("doOrder")
    private DoOrder doOrder;
    public void doOrder(){
        doOrder.demo();
    }
}
