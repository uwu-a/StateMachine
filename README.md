# Lightweight State Machine (Java)

一个轻量级、零依赖的 Java 静态状态机，旨在替代 Spring StateMachine 的重量级设计。

Spring StateMachine 需要为每一个元素（如订单）实例化一个完整的状态机对象以跟踪其状态变化，但在大多数场景下，仅需通过一次性状态查询获取下一个状态并立即销毁。  
因此，本项目实现了一个通用轻量状态机，通过初始化定义状态转移后，即可使用该实例进行状态流转查询和允许操作判断，且不为元素存储当前状态。

---

## ✨ 特性 Features

- ✅ 泛型支持：状态 `State` 与动作 `Action` 均为泛型
- ✅ O(1) 状态转移：基于双键映射结构，查找性能稳定
- ✅ 零依赖：无任何第三方依赖，开箱即用
- ✅ 适合替代 Spring StateMachine：更轻，更快，更易集成

---

## 🧱 快速开始 Quick Start

### 1. 定义状态和动作

```java
enum PlayerState { STOPPED, PLAYING, PAUSED }
enum PlayerAction { PLAY, PAUSE, STOP }
```

### 2. 使用Builder定义转移状态和生成实例

### 3. 提供 trasfer() 和 permit() 方法

trasfer函数提供状态+行为的结果，permit函数提供状态允许的行为。

```
trafer() 函数输入状态和行为，输出下一个状态
permit() 函数输入状态，输出下一个合法的行为集合
