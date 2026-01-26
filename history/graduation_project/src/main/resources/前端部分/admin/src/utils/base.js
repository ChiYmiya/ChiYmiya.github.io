const base = {
    get() {
        return {
            url : "http://localhost:8080/gamemsgbs/",
            name: "gamemsgbs",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gamemsgbs/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "游戏信息平台"
        } 
    }
}
export default base
