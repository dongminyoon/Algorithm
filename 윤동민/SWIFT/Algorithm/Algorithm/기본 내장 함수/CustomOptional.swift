//
//  CustomOptional.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/10/30.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

enum CustomOptional<Wrapped> {
    case some(value: Wrapped)
    case none
    
}

