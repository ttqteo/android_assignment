package com.example.fooddelivery

import android.content.Context
import android.os.Environment
import android.util.Log
import com.example.fooddelivery.model.RestaurantModel
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
object Datastore {

object DataStore {
        fun getDataSet(): List<Restaurant> {
            return listOf(
                Restaurant(33760, "Du Miên Garden Cafe - Phan Văn Trị", "Du Miên Garden Cafe - Phan Văn Trị, Quận Gò Vấp, TP. HCM ", R.drawable.r33760),
                Restaurant(978,"Country House Cafe", "18C Phan Văn Trị, P. 10", R.drawable.r978),
                Restaurant(82801,"Hẻm Spaghetti - Nguyễn Oanh", "212/22 Nguyễn Oanh, P. 17", R.drawable.r82801),
                Restaurant(149154,"Lava Coffee - Quang Trung", "61 Quang Trung, P. 10\",\"District\":\"Quận Gò Vấp\",\"City\":\"TP. HCM", R.drawable.r149154),
                Restaurant(194867,"Mì Cay Naga - 224 Phạm Văn Đồng","224 Phạm Văn Đồng, P.1 Quận Gò Vấp TP. HCM", R.drawable.r194867),
                Restaurant(25656,"City House Cafe - Sân Vườn Lãng Mạn","21 Huỳnh Khương An, P. 5, Quận Gò Vấp, TP. HCM", R.drawable.r25656),
                Restaurant(66844,"Nhi Nhi Quán - Đặc Sản Phan Rang","125/48 Lê Đức Thọ, P. 17,Quận Gò Vấp,TP. HCM", R.drawable.r66844),
                Restaurant(33645,"Yuri Yuri - Ẩm Thực Hàn Quốc","358 Nguyễn Văn Nghi, P. 7, Quận Gò Vấp, TP. HCM", R.drawable.r33645),
                Restaurant(252442,"Trà Sữa Gong Cha - 貢茶 - Phan Văn Trị","595 Phan Văn Trị, P. 5, Quận Gò Vấp, TP. HCM", R.drawable.r252442),
                Restaurant(12513,"Oasis Cafe","26/14 Phạm Văn Đồng, P. 3, Quận Gò Vấp, TP. HCM", R.drawable.r12513),
                Restaurant(199622,"Buzza Pizza - Emart Gò Vấp","Tầng Trệt Emart Gò Vấp - 366 Phan Văn Trị, P. 5, Quận Gò Vấp, TP. HCM", R.drawable.r199622),
                Restaurant(651063,"Dallas Cakes & Coffee - Quang Trung","6 Quang Trung, P. 10, Quận Gò Vấp, TP. HCM", R.drawable.r651063),
                Restaurant(60915,"Hot & Cold - Trà Sữa & Xiên Que - Quang Trung","804 Quang Trung, Quận Gò Vấp, TP. HCM", R.drawable.r60915),
                Restaurant(112585,"Papaxốt - Quang Trung","458 Quang Trung, Quận Gò Vấp, TP. HCM", R.drawable.r112585),
                Restaurant(91979,"SaiGon Chic Cafe","82 Đường Số 27, P. 6, Quận Gò Vấp, TP. HCM", R.drawable.r91979),
                Restaurant(28883,"Pizza Hut - Quang Trung","283 Quang Trung, Quận Gò Vấp, TP. HCM", R.drawable.r28883),
                Restaurant(129725,"Bánh Mì Chảo & Món Ngon Hoa Việt - Quán Cô 3 Hậu","36 Đường Số 18, P. 8, Quận Gò Vấp, TP. HCM", R.drawable.r129725),
                Restaurant(46668,"Kichi Kichi Lẩu Băng Chuyền - Quang Trung","1 Quang Trung, Quận Gò Vấp, TP. HCM", R.drawable.r46668),
                Restaurant(158187,"The Coffee House - Quang Trung","293 Quang Trung, Quận Gò Vấp, TP. HCM", R.drawable.r158187),
                Restaurant(30102,"Cánh Đồng Quán - Lẩu Nướng Tại Bàn - Dương Quảng Hàm","310/14 Dương Quảng Hàm, P. 5, Quận Gò Vấp, TP. HCM", R.drawable.r30102),
                Restaurant(83857,"Chú Tèo Buffet Nướng 99K - K26 Dương Quảng Hàm","N01 Chung Cư K26 Dương Quảng Hàm, P. 7, Quận Gò Vấp, TP. HCM", R.drawable.r83857),
                Restaurant(212102,"Food Court - E Mart Gò Vấp","Tầng Trệt E - Mart Gò Vấp, 168 Phan Văn Trị, P. 5, Quận Gò Vấp, TP. HCM", R.drawable.r212102),
                Restaurant(67764,"Bánh Tráng Deli & Xiên Que - Lê Đức Thọ","730/7/5 Lê Đức Thọ, P. 15, Quận Gò Vấp,TP. HCM", R.drawable.r67764),
                Restaurant(232015,"Cowboy Jack's - American Dining - Lotte Mart Gò Vấp","Tầng 1, Lotte Mart Gò Vấp, 242 Nguyễn Văn Lượng, P. 10, Quận Gò Vấp, TP. HCM", R.drawable.r232015),

            )
        
    }
}
