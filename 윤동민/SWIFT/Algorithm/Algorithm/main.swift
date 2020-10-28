//
//  main.swift
//  Algorithm
//
//  Created by 윤동민 on 2020/06/08.
//  Copyright © 2020 윤동민. All rights reserved.
//

import Foundation

var copyMap = CopyMap(array: ["a", "b", "c", "k", "z"])

print(copyMap.map(transform: { $0 + "a" }))
