package com.project.fiction.serviceimpl;

import com.project.fiction.dao.BookUserMapper;
import com.project.fiction.dao.bookinformationMapper;
import com.project.fiction.pojo.bookinformation;
import com.project.fiction.pojo.bookuser;
import com.project.fiction.serivce.informationService;
import jdk.nashorn.internal.runtime.Source;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class informationServiceImpl implements informationService {
    @Autowired
    private bookinformationMapper bookinformationMapper;

    @Override
    public List<bookuser> getUserRole(String username) {
        return bookinformationMapper.selectUserRole(username);
    }

    /**
     * 随机抽取九本书
     * @param
     * @return
     */
    @Override
    public List<bookinformation> getbookByRandom() {
        Random random = new Random();
        List<bookinformation> bookinformations = new ArrayList<bookinformation>();
        List<Integer> rand = new ArrayList<Integer>();
        int b = 9;
        for (int i = 0; i < b; i++) {
            int c = 0;
            int bookid = random.nextInt(162) + 240;
            System.out.println("随机数:" + bookid);
            rand.add(bookid);
            if (i!=0) {
                for (int a = 0; a < rand.size()-1; a++){
                    if (bookid==rand.get(a)) {
                        b++;
                        c = 1;
                        rand.remove(a);
                    }
                }
            }
            if (c == 1) {
                continue;
            }
            /*for (int a=0; a < rand.length; a++){
                if (rand.length>1) {
                    for (int d = 0; d < rand.length; d++){
                        if (rand[i]==rand[d-a]) {
                        }
                    }
                }
            }*/
            bookinformation bookinformation = bookinformationMapper.selectbookByRandom(bookid);
            try {
                if (!bookinformation.getAuthod().equals("")||bookinformation.getAuthod()!=null) {
                    bookinformation.setAuthod(bookinformation.getAuthod().replace("作者：", ""));
                }
            }catch (NullPointerException e){
                b++;
                continue;
            }
            String str01 = null;
            String str02 = null;
            if (bookinformation.getSynopsis().length() == 0 || bookinformation.getSynopsis().length() <= 12) {
                bookinformation.setSynopsis("暂无简介<br><br>");
            }else {
                if (bookinformation.getSynopsis().length() > 24) {
                    str01 = bookinformation.getSynopsis().substring(0, 12);
                    str02 = bookinformation.getSynopsis().substring(12, 24);
                    bookinformation.setSynopsis(str01 + "<br>" + str02);
                }else {
                    if (bookinformation.getSynopsis().length() > 12) {
                        str01 = bookinformation.getSynopsis().substring(0, 12);
                        str02 = bookinformation.getSynopsis().substring(12, bookinformation.getSynopsis().length());
                        bookinformation.setSynopsis(str01 + "<br>" + str02);
                    }else {
                        str01 = bookinformation.getSynopsis().substring(0, bookinformation.getSynopsis().length());
                        bookinformation.setSynopsis(str01 + "<br>");
                    }
                }
            }
            bookinformations.add(bookinformation);

        }
        return bookinformations;
    }

    @Override
    public bookuser login(String username, String password) {
        bookuser bookuser = bookinformationMapper.selectUserByUsernameAndpwd(username, password);
        return bookuser;
    }
}
