package org.lua.entity.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.lua.constant.Constant;
import org.lua.entity.BaseEntity;
import org.lua.entity.StateMachine;
import org.lua.util.StringUtils;
import org.lua.web.BaseFormBean;
import org.lua.web.test.formbean.PlanFB;
import org.springframework.beans.BeanUtils;


/**
 * @author AMGuo E-mail:www.guoao@foxmail.com
 * @version 创建时间：2017年3月24日 下午2:59:13 类说明
 */
@Entity
@Table(name = "tbl_plan")
public class Plan extends BaseEntity<Plan> implements StateMachine {

    /**
     *
     */
    public static String state[] = {"新建", "审批中", "已审批"};

    private static final long serialVersionUID = 249207502801980439L;

    private String name;

    private Date createDate;

    private String status;

    public Plan(String name, Date createDate, String status) {
        super();
        this.name = name;
        this.createDate = createDate;
        this.status = status;
    }

    public Plan() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCurrentState() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getAllState() {
        // TODO Auto-generated method stub
        return null;
    }

    public String[] getNextAction() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getNextStatus(String action) {
        if (action.equals(Constant.MESSAGE_TONGYI))
            return StringUtils.getNext(state, status);
        else
            return StringUtils.getPrevious(state, status);

    }

    public BaseEntity doAction(String action) {
        // 更新状态
        status = getNextStatus(action);
        setStatus(status);
        return this;
    }

    public Map allVariable() {
        // TODO Auto-generated method stub
        return null;
    }

    public int getColumn() {
        // TODO Auto-generated method stub
        return 0;
    }

    public BaseFormBean toTableBean(BaseEntity baseEntity) {
        Plan plan = (Plan) baseEntity;
        PlanFB fb = new PlanFB();
        BeanUtils.copyProperties(plan, fb);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fb.setCreateDate(sdf.format(new Date()));
        return fb;
    }

}
