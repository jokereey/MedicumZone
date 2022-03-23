package com.project.medicumzone.service.contract;

import java.time.LocalDateTime;

public interface HourCheck {
    public boolean hourCheck(LocalDateTime time,Long... targetId);
}
