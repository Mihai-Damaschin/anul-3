import { useEffect, useRef } from "react";
import {
  BoxGeometry,
  Color,
  DirectionalLight,
  EdgesGeometry,
  GridHelper,
  HemisphereLight,
  LineBasicMaterial,
  LineSegments,
  Mesh,
  MeshPhongMaterial,
  Object3D,
  PerspectiveCamera,
  PlaneBufferGeometry,
  Raycaster,
  Scene,
  Vector2,
  WebGLRenderer,
} from "three";
import { GLTFLoader } from "three/examples/jsm/loaders/GLTFLoader";

import { DRACOLoader } from "three/examples/jsm/loaders/DRACOLoader";
import { OrbitControls } from "three/examples/jsm/controls/OrbitControls";
import { useStateHandlers } from "hooks/useStateHandlers";

const MOVE_DISTANCE = 1;

export const Test1 = () => {
  const sceneDiv = useRef<HTMLDivElement>(null);
  const { current: camera } = useRef(
    new PerspectiveCamera(120, window.innerWidth / window.innerHeight, 1, 2000)
  );
  const { current: scene } = useRef(new Scene());
  const { current: renderer } = useRef(
    new WebGLRenderer({ antialias: true, alpha: true })
  );
  const { current: controls } = useRef(
    new OrbitControls(camera, renderer.domElement)
  );

  const [state, setState] = useStateHandlers({
    camera: {
      x: 10,
      y: 2,
      z: 0,
    },
  });

  useEffect(() => {
    const container = document.createElement("div");

    if (sceneDiv.current) {
      sceneDiv.current.appendChild(container);
    }

    console.log(window.location.hash + "/mainHall.gltf");

    scene.background = new Color(0xffffff);

    //   const texture = new TextureLoader().load( "./assets/textureback.jpeg" );
    //   scene.background = texture;

    const raycaster = new Raycaster();
    const mouse = new Vector2();

    const ambient = new HemisphereLight(0xffffff, 0xbbbbff, 0.3);
    scene.add(ambient);

    const light = new DirectionalLight();
    light.position.set(1, 1, 1);
    scene.add(light);

    renderer.setPixelRatio(window.devicePixelRatio);
    if (sceneDiv.current) {
      renderer.setSize(window.innerWidth, window.innerHeight);
    }

    container.appendChild(renderer.domElement);

    let dolly = new Object3D();
    dolly.position.set(0, -1, 0);
    dolly.add(camera);
    let dummyCam = new Object3D();
    camera.add(dummyCam);

    initScene();
    gltfLoadModel();

    renderer.setAnimationLoop(render.bind(this));

    window.addEventListener("resize", resize.bind(this));

    function resize() {
      camera.aspect = window.innerWidth / window.innerHeight;
      camera.updateProjectionMatrix();
      renderer.setSize(window.innerWidth, window.innerHeight);
    }

    function render() {
      // mesh.rotateY( 0.01 );
      // update the picking ray with the camera and mouse position

      // raycaster.setFromCamera(mouse, camera);

      // calculate objects intersecting the picking ray
      // const intersects = raycaster.intersectObjects(scene.children);

      renderer.render(scene, camera);
    }

    function initScene() {
      scene.background = new Color(0xa0a0a0);
      // scene.fog = new Fog( 0xa0a0a0, 50, 100 );

      // ground
      const ground = new Mesh(
        new PlaneBufferGeometry(200, 200),
        new MeshPhongMaterial({ color: 0x999999, depthWrite: false })
      );
      ground.rotation.x = -Math.PI / 2;
      scene.add(ground);

      let grid = new GridHelper(500, 40, 0x000000, 0x000000);
      // @ts-ignore
      grid.material.opacity = 0.2;
      // @ts-ignore
      grid.material.transparent = true;
      scene.add(grid);
    }

    function onMouseMove(event: any) {
      // calculate mouse position in normalized device coordinates
      // (-1 to +1) for both components

      mouse.x = (event.clientX / window.innerWidth) * 2 - 1;
      mouse.y = -(event.clientY / window.innerHeight) * 2 + 1;
    }
    window.addEventListener("mousemove", onMouseMove);

    const clickMouse = new Vector2();

    window.addEventListener("click", identifyMesh);

    function identifyMesh(event: any) {
      clickMouse.x = (event.clientX / window.innerWidth) * 2 - 1;
      clickMouse.y = (event.clientY / window.innerHeight) * 2 - 1;

      raycaster.setFromCamera(clickMouse, camera);
      const found = raycaster.intersectObjects(scene.children, true);

      console.log("Clicked object", found);
    }

    function gltfLoadModel() {
      const loader = new GLTFLoader();

      // Optional: Provide a DRACOLoader instance to decode compressed mesh data
      const dracoLoader = new DRACOLoader();
      dracoLoader.setDecoderPath("/examples/js/libs/draco/");
      loader.setDRACOLoader(dracoLoader);

      // Load a glTF resource
      loader.load(
        // resource URL
        window.location.hash + "/models/mainHall.gltf",
        // called when the resource is loaded
        function (gltf) {
          console.log(gltf, "gltf");
          scene.add(gltf.scene);

          // @ts-ignore
          renderer.setAnimationLoop(render.bind(this));
        },
        // called while loading is progressing
        function (xhr) {
          console.log((xhr.loaded / xhr.total) * 100 + "% loaded");
        },
        function (error) {
          console.error("An error happened", error);
        }
      );
    }

    controls.keys = {
      LEFT: "ArrowLeft", //left arrow
      UP: "ArrowUp", // up arrow
      RIGHT: "ArrowRight", // right arrow
      BOTTOM: "ArrowDown",
    };
    controls.enabled = true;

    function handleKeyDown(event: any) {
      console.log("on key press");
      switch (event.key) {
        case "w":
        case "W":
          setState((prevState) => ({
            camera: {
              ...prevState.camera,
              y: prevState.camera.y - MOVE_DISTANCE,
            },
          }));
          break;
        case "s":
        case "S":
          setState((prevState) => ({
            camera: {
              ...prevState.camera,
              y: prevState.camera.y + MOVE_DISTANCE,
            },
          }));
          break;
        case "a":
        case "A":
          setState((prevState) => ({
            camera: {
              ...prevState.camera,
              x: prevState.camera.x + MOVE_DISTANCE,
            },
          }));
          break;
        case "d":
        case "D":
          setState((prevState) => ({
            camera: {
              ...prevState.camera,
              x: prevState.camera.x - MOVE_DISTANCE,
            },
          }));
          break;
        case "ArrowUp":
          setState((prevState) => ({
            camera: {
              ...prevState.camera,
              z: prevState.camera.z + MOVE_DISTANCE,
            },
          }));
          break;
        case "ArrowDown":
          setState((prevState) => ({
            camera: {
              ...prevState.camera,
              z: prevState.camera.z - MOVE_DISTANCE,
            },
          }));
          break;
        default:
          break;
      }
    }

    document.addEventListener("keydown", handleKeyDown);
  }, []);

  useEffect(() => {
    console.log(
      state.camera.x,
      state.camera.y,
      state.camera.z,
      "on camera change"
    );
    camera.position.set(state.camera.x, state.camera.y, state.camera.z);

    camera.updateProjectionMatrix();
  }, [state.camera]);

  return <div ref={sceneDiv} />;
};
