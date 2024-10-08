export function toPreview(path: string) {
  let url = 'http://192.168.0.217:8095/web-reader/reader';
  if (0 > location.host.indexOf('192.168.0')) {
    url = 'http://59.208.71.59:9094/web-reader/reader';
  }
  window.open(url + '?file=' + encodeURIComponent('http://192.168.0.104:81/hbdzzz/sys/common/static/' + path));
}
