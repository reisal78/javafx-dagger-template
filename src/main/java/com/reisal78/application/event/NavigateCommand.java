package com.reisal78.application.event;

import com.reisal78.application.view.base.IView;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class NavigateCommand {
    private final Class<? extends IView> view;


}
