package org.lua.repository;

import org.lua.entity.MessageRepient;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepientDao  extends BaseRepository<MessageRepient, Long>, JpaSpecificationExecutor<MessageRepient>{
    
    /**
     * 查询用户未读消息的个数
     * @param userId
     * @return
     */
    @Query("SELECT COUNT(entity) FROM MessageRepient entity WHERE entity.repientUser.id=?1 AND entity.read=FALSE")
    public Long findUnreadCount(Long userId);
    
    /**
     * 消息设置为已读
     * @param id
     */
    @Modifying
    @Query("UPDATE MessageRepient entity SET entity.read=TRUE WHERE entity.id=?1")
    public void read(Long id);
    
    /**
     * 消息设置为未读
     * @param id
     */
    @Modifying
    @Query("UPDATE MessageRepient entity SET entity.read=FALSE WHERE entity.id=?1")
    public void unRead(Long id);
}

