package forfun.good.a20180117.data;

import android.content.Context;

/**
 * Created by Student on 2018/1/18.
 */
//用來切換控制檔案存在記憶體還是文件中或資料庫
public class studentDAOFactory {
    public static  StudentDAO getDAOInstance(Context context,DBtype dbtype)
    {
        switch (dbtype) //開關
        {
            case Memory:
                return new StudentscoreDAO();
            case File:
                return new StudentFileDAO(context);
            case DB:
                return new StudentDAODBImpl(context);
        }return null;
    }
}
