export interface AHapticPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
