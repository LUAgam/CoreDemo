/**
 * 
 */
package org.lua.repository;

import org.lua.entity.QuartzJob;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author onkyo
 *
 */
public interface QuartzJobDao  extends BaseRepository<QuartzJob, Long>, JpaSpecificationExecutor<QuartzJob> {

}
