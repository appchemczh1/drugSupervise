import 'uno.css';
import '/@/design/index.less';
import 'ant-design-vue/dist/reset.css';
// 注册图标
import 'virtual:svg-icons-register';

import App from './App.vue';
import Antd from 'ant-design-vue';
import { createApp } from 'vue';
import { initAppConfigStore } from '/@/logics/initAppConfig';
import { setupErrorHandle } from '/@/logics/error-handle';
import { router, setupRouter } from '/@/router';
import { setupRouterGuard } from '/@/router/guard';
import { setupStore } from '/@/store';
import { setupGlobDirectives } from '/@/directives';
import { setupI18n } from '/@/locales/setupI18n';
import { registerGlobComp } from '/@/components/registerGlobComp';
import { registerThirdComp } from '/@/settings/registerThirdComp';
import { useSso } from '/@/hooks/web/useSso';
// 注册online模块lib
import { registerPackages } from '/@/utils/monorepo/registerPackages';

import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import zhCn from 'element-plus/es/locale/lang/zh-cn';
import * as ElementPlusIconsVue from '@element-plus/icons-vue';
async function bootstrap() {
  // 创建应用实例
  const app = createApp(App);
  for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component);
  }
  // 多语言配置,异步情况:语言文件可以从服务器端获得
  await setupI18n(app);
  app.use(ElementPlus, {
    locale: zhCn,
  });
  app.use(Antd);

  // 配置存储
  setupStore(app);

  // 初始化内部系统配置
  initAppConfigStore();

  // 注册外部模块路由(注册online模块lib)
  registerPackages(app);

  // 注册全局组件
  registerGlobComp(app);

  //CAS单点登录
  await useSso().ssoLogin();

  // 配置路由
  setupRouter(app);

  // 路由保护
  setupRouterGuard(router);

  // 注册全局指令
  setupGlobDirectives(app);

  // 配置全局错误处理
  setupErrorHandle(app);

  // 注册第三方组件
  await registerThirdComp(app);

  // 当路由准备好时再执行挂载( https://next.router.vuejs.org/api/#isready)
  await router.isReady();

  // 挂载应用
  app.mount('#app', true);

  console.log(' vue3 app 加载完成！');
}

bootstrap();
