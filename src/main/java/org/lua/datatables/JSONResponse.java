/**
 * (c) 2006 JOVEN
 * <p>
 * http://www.joven.com.cn
 */
package org.lua.datatables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * The data tables response.
 *
 * @author $Author: JHuang $
 * @version $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */
public class JSONResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4781385361372703308L;

    //@JsonProperty(value = "iTotalRecords")
    public int totalRecords;

    //@JsonProperty(value = "iTotalDisplayRecords")
    public int totalDisplayRecords;

    //@JsonProperty(value = "sEcho")
    public String echo;

    //@JsonProperty(value = "sColumns")
    public String columns;

    //@JsonProperty(value = "aaData")
    public List data = new ArrayList();

    public JSONResponse() {
    }
}
