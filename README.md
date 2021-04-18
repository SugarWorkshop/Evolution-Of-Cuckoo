🌏 [简体中文](README.md) ● [English](README-en_us.md)

# Evolution Of Cuckoo 1.12

这是 Minecraft 1.12.2 版本的模组 Evolution Of Cuckoo（不咕鸟の进化）的代码仓库。

<img src=".\docs_images\logo.png" width="50%">

# 目录

- [Evolution Of Cuckoo 1.12](#evolution-of-cuckoo-112)
- [目录](#目录)
- [模组介绍](#模组介绍)
- [开发状态](#开发状态)
- [模组基本信息](#模组基本信息)
- [如何游玩](#如何游玩)
- [开发者指南](#开发者指南)
  - [如何构建](#如何构建)
  - [与 CuckooLib 协同开发](#与-cuckoolib-协同开发)
- [特别鸣谢](#特别鸣谢)

# 模组介绍

**Cuckoo Dev Team**，是一个 Minecraft Mod 开发团队，团队成员们**成绩优越、品德高尚、乐于助人、和蔼可亲、人见人爱**，为团队做出了**莫大贡献**，所以团队的一名成员（ [@Mo_Ink](https://github.com/Mo-Ink) ）决定编写一个模组，以此**纪念团队和感恩成员们的高尚道德情操**，让每一个 Minecraft 玩家都能感受到**不咕鸟的魅力**。

# 开发状态

EOC 目前由 **Cuckoo Dev Team** 维护，目前处于非常早期的版本；EOC 目前还没有发布公开的正式版本。如果你对这个模组有意见或建议，你可以直接联系我们或者[提出 Issue](https://github.com/Mo-Ink/Evolution-Of-Cuckoo/issues)。

# 模组基本信息

- Minecraft 版本: 1.12.2
- Forge 版本: 14.23.5.2847
- 最新稳定版本: [![Latest-Stable](https://img.shields.io/github/v/release/Mo-Ink/Evolution-Of-Cuckoo)](https://github.com/Mo-Ink/Evolution-Of-Cuckoo/releases)
- 最新版本: [![Latest](https://img.shields.io/github/v/release/Mo-Ink/Evolution-Of-Cuckoo?include_prereleases)](https://github.com/Mo-Ink/Evolution-Of-Cuckoo/releases)

# 如何游玩

1. 确保您已经安装 **Minecraft 1.12.2** 和 **Forge 14.23.5.2847**
2. 前往 **[Release 页面](https://github.com/Mo-Ink/Evolution-Of-Cuckoo/releases)**
3. 单击你想游玩的版本
4. 下载 **Assets** 中的 `EOC-Build.tar` 并解压
5. 将不带 `-sources` 字样的 `.jar` 文件复制到 `.minecraft\mods` 文件夹

# 开发者指南

## 如何构建

请在项目根目录执行以下命令：

```
* Windows *
gradlew build

* Linux / Unix *
./gradlew build
```

构建完成后，你可以在 `build/libs` 目录找到生成的归档文件。

**注意：如果你遇到了编译错误，你可以试试[引入 CuckooLib 仓库](#与-cuckoolib-协同开发)，这可能会解决问题。**

## 与 CuckooLib 协同开发

[CuckooLib](https://github.com/zi-jing/CuckooLib) 是 EOC 项目的一个依赖库，包含了 Cuckoo Dev Team 需要用到的大量可重用代码。

如果你想更好地调试 EOC 项目或利用 EOC 项目来调试 CuckooLib，你可以 Clone [CuckooLib 仓库](https://github.com/zi-jing/CuckooLib)，然后在 EOC 项目根目录创建文件`gradle.properties`，添加以下内容：

```properties
CuckooLibIncludeBuildPath=../CuckooLib
```

其中，键`CuckooLibIncludeBuildPath`的值为 CuckooLib 项目根目录路径。

保存文件，在 IDE 中刷新 Gradle 项目，即可引入 CuckooLib 项目。

# 特别鸣谢

1. 成绩优越、品德高尚、乐于助人、和蔼可亲、人见人爱の领袖 [@gonggongjohn](https://github.com/gonggongjohn)
2. 此 Mod 名字的由来 [Evolution-Of-Knowledge](https://github.com/gonggongjohn/Evolution-Of-Knowledge)
3. 可能会作为依赖库的 [CuckooLib](https://github.com/zi-jing/CuckooLib)
4. 此模组的前身 [Evolution-Of-Zijing](https://github.com/Wu-baozi/Evolution-Of-Zijing)
